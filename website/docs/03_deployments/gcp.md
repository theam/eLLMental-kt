# GCP App Engine

This document will show you how to deploy the __eLLMental__ application to GCP. It requires little to no previous knowledge of GCP, but it is recommend to be at least familiar with some of it's basic terminology. The only requirements for this walkthrough is that you have a GCP account and the [gcloud](https://cloud.google.com/sdk/docs/install) CLI installed in your system. It also won't breach free tier if the smaller free tier instances are selected (this is selected by default).


## Intro to App Engine

App Engine is a GCP service created to do quick deployments without worrying about designing systems and connecting different services. It requires little configuration and most default settings are good enough for standard deployments. The nice thing about App Engine is that it can be tailored to your needs if necessary and it offers pretty advanced configuration options if required.


## Creating a App Engine Service

Once you have created your GCP account and installed `gcloud` to your system, you can then clone this repository to your local computer. The following steps will assume that you have done that and that you are running the command from inside the repo root folder.



1. (__Optional__)  First, create a Google Cloud project, which is a top-level container holding application resources. If you don't need a new project, skip this step. For example, the command below creates a project with the `ellmental-sample-app-engine` name (use a unique name or else it will conflict with other projects with the same name):


```sh
    gcloud projects create ellmental-sample-app-engine --set-as-default
```

2. (__Optional__)  If app is already created in the project, then you can skip this step. Create an App Engine application for the Cloud project:

```sh
    gcloud app create
```

> If you receive the `Cloud Build has not been used in project` error during the build, enable it by using instructions from the error report.


3. To deploy the application, execute the `appengineDeploy` Gradle task...

```sh
    ./gradlew :semantic-search-service-demo:appengineDeploy
```

Now wait for the application to be deployed and you'll receive a message similar to this:

```
    ....................................done.
    Deployed service [default] to [https://ellmental-sample-app-engine.uc.r.appspot.com]
```

To test the deployment you can access the endpoint printed while running the `appengineDeploy` command. In our case it was the __https://ellmental-sample-app-engine.uc.r.appspot.com__ endpoint. 


> Make sure that your application is either using the App Engine environment variable called `PORT` to set the application port or that it's using port `8081` by default.


If your application deploys but the endpoint isn't returning your application endpoints, then the best way to find out what is happening is looking at the logs. To get the logs, access the GCP console in a web browser and go to the `App Engine` service. Select the services tab on the left menu and a table will appear on the right with a `default` service. Click on the logs link in the `Diagnose` column. This will show your application logs and more importantly any errors that might be happening. 

