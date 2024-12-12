# selenium-java-cookbook

### Creating an Azure Credentials
```bash
# Azure CLI command
az ad sp create-for-rbac --name "GitHubActions" --role contributor \
    --scopes /subscriptions/{subscription-id}/resourceGroups/{resource-group} \
    --sdk-auth
```

### Azure Key Vault Permissions:
Ensure the service principal has "Get" and "List" permissions for secrets in the Key Vault.