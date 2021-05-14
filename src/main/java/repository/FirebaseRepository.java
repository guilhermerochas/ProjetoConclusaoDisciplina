package repository;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.storage.Bucket;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;
import resources.LocalizacaoItemResource;
import resources.LocalizacaoResource;
import utils.OSUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

public class FirebaseRepository implements IRepository {
    private final Bucket Imagebucket;
    private final Firestore db;

    public FirebaseRepository() throws Exception {
        FileInputStream serviceConfig = new FileInputStream("./serviceKey.json");
        FirebaseOptions opts = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceConfig))
                .setStorageBucket("infocep-cad3e.appspot.com")
                .build();
        FirebaseApp.initializeApp(opts);

        Imagebucket = StorageClient.getInstance().bucket();
        db = FirestoreClient.getFirestore();
    }

    @Override
    public List<LocalizacaoItemResource> obterLocalizacoes() throws Exception {
        QuerySnapshot query = db.collection("info").get().get();
        List<LocalizacaoItemResource> items = query.toObjects(LocalizacaoItemResource.class);
        return items;
    }

    @Override
    public Optional<LocalizacaoResource> obterLocalizacao(String id) throws Exception {
        DocumentSnapshot document = db.collection("info").document(id).get().get();
        if(document.exists()) {
            Map<String, Object> set = document.getData();
            return Optional.of(new LocalizacaoResource()
                    .setId((String) set.get("id"))
                    .setLocalidade((String) set.get("localidade"))
                    .setCep((String) set.get("cep"))
                    .setLatitude((String) set.get("latitude"))
                    .setLongitude((String) set.get("longitude"))
                    .setTempo((String) set.get("tempo"))
                    .setUf((String) set.get("tempo"))
                    .setImageUrl((String) set.get("imageUrl")));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Boolean criarLocalizacao(LocalizacaoResource resource) {
        try {
            AtomicReference<Boolean> errorFlag = new AtomicReference<>(false);

            OSUtils.getFilesFromDir("./imgs/db").forEach(image -> {
                try {
                    String slashType = OSUtils.getOsType().startsWith("Windows") ? "\\\\" : "/";
                    String[] filePathArray = image.split(slashType);
                    String bucketName = Imagebucket.create(filePathArray[filePathArray.length - 1], new FileInputStream(image)).getBucket();
                    resource.setImageUrl(bucketName + "/" + filePathArray[filePathArray.length - 1]);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    errorFlag.set(true);
                }
            });

            if(errorFlag.get())
                return false;

            OSUtils.getFilesFromDir("./imgs/db").forEach(image -> new File(image).delete());

            DocumentReference docRef = db.collection("info").document(String.valueOf(resource.hashCode()));

            Map<String, Object> data = new HashMap<>() {{
               put("id", resource.hashCode());
               put("cep", resource.getCep());
               put("localidade", resource.getLocalidade());
               put("uf", resource.getUf());
               put("longitude", resource.getLongitude());
               put("latitude", resource.getLatitude());
               put("tempo", resource.getTempo());
               put("imageUrl", resource.getImageUrl());
            }};

            docRef.set(data).get();

            return true;
        } catch (Exception _e) {
            return false;
        }
    }
}
