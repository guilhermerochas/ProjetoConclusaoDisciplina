.\mvnw.cmd clean package
if ( $? -eq $True ) {
    $firstArg = $args[0]
    switch($firstArg) {
        '-d' {
            [System.Environment]::SetEnvironmentVariable('DEPLOY_MODE','Development')
            $file = ((Get-ChildItem -File -Recurse .\target\).FullName | Select-String -Pattern jar)
            java -jar $file
        }
        '-p' {
            [System.Environment]::SetEnvironmentVariable('DEPLOY_MODE','Production')
            $file = ((Get-ChildItem -File -Recurse .\target\).FullName | Select-String -Pattern jar)
            java -jar $file
        }
        default {
            [System.Environment]::SetEnvironmentVariable('DEPLOY_MODE','Development')
            $file = ((Get-ChildItem -File -Recurse .\target\).FullName | Select-String -Pattern jar)
            java -jar $file
        }
    }
} else {
    Write-Host "Não foi possível gerar ou rodar o executavel"
}