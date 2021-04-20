# Heroku
## Deploy
[Deploying Spring Boot](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku)

```shell
heroku create
git push heroku master
heroku config:set msteamsHook=
heroku config:set giphy.apiKey=
heroku apps:rename happy-giphy
```

To link existing folder
```shell
heroku git:remote -a happy-giphy
```

## Scheduler
[Heroku Scheduler](https://devcenter.heroku.com/articles/scheduler)
```shell
heroku addons:create scheduler:standard
heroku addons:open scheduler
```
