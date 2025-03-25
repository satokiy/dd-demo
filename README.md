# About

Datadogお試しアプリケーション

# Stack
- Kotlin(Spring Boot)
- AWS EKS
- Argo CD

※ローカルPCからEKSにデプロイするためには、ARM instance 向けにイメージをビルドする必要があります。

# Workflow
main ブランチにマージされるとGithub Actionsが実行され、EKSにデプロイされます。
