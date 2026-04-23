# DevOps Automation Lab — CI/CD com GitHub Actions

Projeto educacional criado para a disciplina de DevOps, com foco na automação de pipelines CI/CD utilizando GitHub Actions, Java, Maven e Docker.

---

## 📋 Índice

- Segurança e Decisões de Projeto  
- Lab 1 — Pipeline Básica  
- Lab 2 — CI/CD com Java e Docker  
- Evidências  
- Conclusão  
- Próximos Passos  

---

## 🔐 Segurança e Decisões de Projeto

No roteiro original do Lab 2, era solicitado clonar um repositório externo desconhecido e copiar seus arquivos diretamente para o projeto. Por questões de segurança, essa etapa foi substituída por uma implementação própria, sem comprometer os objetivos pedagógicos da atividade.

| Decisão | Motivo |
|--------|--------|
| ✅ Aplicação Java desenvolvida do zero | Evitar execução de código de origem desconhecida |
| ✅ Utilização apenas de actions oficiais do GitHub | `actions/checkout`, `actions/setup-java`, `actions/upload-artifact` são mantidas pelo GitHub |
| ✅ Uso de imagem base Docker oficial | `eclipse-temurin:17-jdk-alpine` é mantida pela Eclipse Foundation / Adoptium |
| ✅ Simulação de scan de segurança com `echo` | Evita uso de ferramentas externas não auditadas em ambiente local |
| ✅ Ausência de `curl \| bash` ou scripts remotos | Nenhum comando realiza download e execução de scripts externos |
| ✅ Nenhum secret exposto no código | Credenciais documentadas apenas como referência estrutural |

---

# 🧪 Lab 1 — Pipeline Básica

## 🎯 Objetivo

Validar o funcionamento do GitHub Actions por meio de um workflow simples, configurando o repositório e executando a primeira automação.

---

## 🏗️ Estrutura do Projeto

```text
workspace-devops-automation/
├── .github/
│   └── workflows/
│       └── hello.yml
└── README.md
```

---

## ⚙️ Passos Executados

### 1. Criar a estrutura local

```bash
mkdir workspace-devops-automation
cd workspace-devops-automation
```

### 2. Criar o repositório no GitHub

- Acesse https://github.com
- Clique em New Repository
- Nome: `workspace-devops-automation`

### 3. Inicializar Git e conectar ao remoto

```bash
git init
git remote add origin https://github.com/Felipe-SMZ/workspace-devops-automation.git
git add .
git commit -m "first commit"
git branch -M main
git push -u origin main
```

### 4. Workflow básico

```yaml
name: Hello GitHub Actions
on:
  push:
    branches: [main]

jobs:
  say-hello:
    runs-on: ubuntu-latest
    steps:
      - run: echo "✅ GitHub Actions funcionando com sucesso!"
```

---

# 🧪 Lab 2 — CI/CD com Java e Docker

## 🎯 Objetivo

Construir uma pipeline completa contemplando build, testes, containerização e simulação de deploy — com código totalmente autoral.

## ☕ Aplicação Java

```java
public class App {
    public static void main(String[] args) {
        System.out.println("API DevOps rodando com sucesso!");
    }
}
```

## 📦 Build

`pom.xml` é essencial para executar:

```bash
mvn clean package
```

## 🐳 Dockerfile

```dockerfile
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/devops-api-1.0.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
```

## 📸 Evidências

- Build Maven com sucesso
- Aplicação rodando no navegador
- Container Docker funcionando
- Pipeline completa com steps verdes

---

# 🧠 Conclusão

Este projeto demonstra:

- GitHub Actions para automação
- Java + Maven para build e testes
- Docker para containerização
- Boas práticas de segurança

A principal adaptação foi substituir o clone de repositório externo por solução própria.
