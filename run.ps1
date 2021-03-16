.\mvnw.cmd clean package
if ( $? -eq $True ) {
    $file = ((Get-ChildItem -File -Recurse .\target\).FullName | Select-String -Pattern jar)
    java -jar $file
} else {
    Write-Host "Não foi possível gerar ou rodar o executavel"
}