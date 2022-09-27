Setting up the development environment for Vscode 
=================================================

Requirements:
-------------
- Docker
- Vscode
    - [Dev Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)


Dev Container:
-------------
- Create .devcontainer/Dockerfile
- Create `.devcontainer/devcontainer.json` file

```
// Dockerfile
# See here for image contents: https://github.com/microsoft/vscode-dev-containers/tree/v0.241.1/containers/java/.devcontainer/base.Dockerfile

# [Choice] Java version (use -bullseye variants on local arm64/Apple Silicon): 11, 17, 11-bullseye, 17-bullseye, 11-buster, 17-buster
ARG VARIANT="11"
FROM mcr.microsoft.com/vscode/devcontainers/java:0-${VARIANT}

ARG GRADLE_VERSION=""

RUN su vscode -c "umask 0002 && . /usr/local/sdkman/bin/sdkman-init.sh && sdk install gradle \"${GRADLE_VERSION}\""

ENV GRADLE_USER_HOME=/home/vscode/.gradle
ENV JAVA_HOME=/usr/lib/jvm/msopenjdk-current

RUN mkdir -p $GRADLE_USER_HOME && \
    chown -R vscode:vscode $GRADLE_USER_HOME
```


``` 
// devcontainer.json
{
	"name": "TSP Java Client",
	"build": {
		"dockerfile": "Dockerfile",
		"args": {
			"VARIANT": "11"
		}
	},
	"customizations": {
		"vscode": {
			"settings": {
				"terminal.integrated.defaultProfile.linux": "zsh",
				"java.configuration.updateBuildConfiguration": "automatic",
				"editor.formatOnSave": true,
				"editor.codeActionsOnSave": {
					"source.fixAll": true,
					"source.organizeImports": true
				}
			},
			"extensions": [
				"vscjava.vscode-java-pack",
				"mhutchie.git-graph",
				"richardwillis.vscode-gradle-extension-pack",
				"mathiasfrohlich.Kotlin"
			]
		}
	},
	"mounts": [
        // If you use SSH connection
		// "source=${localEnv:HOME}/.ssh,target=/home/vscode/.ssh,type=bind", 
		"source=tsp-client-java-gradle-cache,target=/home/vscode/.gradle,type=volume"
	],
	"remoteUser": "vscode"
}
```


Open Dev Container:
-------------------
- Open the folder *tsp-javaj-client* with Vscode
- Open the command prompt `CTRL+SHIFT+P`
- Run the *Remote-Containers: Reopen In Container* command






