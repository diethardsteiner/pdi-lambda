# pdi-lambda
Code for running PDI in AWS Lambda

# Notes from a conversion with Dan 2011-03-01

Dan integrated PDI with AWS Lambda over 4 years ago. There were certain limitations in place that have been eased in the meantime.

My main aim was to understand how Dan this with PDI so that I could try something simiar with Apache Hop.

Vital docs are:

- [Java Programming Model](http://docs.aws.amazon.com/lambda/latest/dg/java-programming-model.html)
- [Create Jar](http://docs.aws.amazon.com/lambda/latest/dg/java-create-jar-pkg-maven-no-ide.html)

Dan's approach consisted of 2 steps:

## Step 1: Build the package: 

Dan had to upload a jar, but today you can upload a zip ... this is much easier, so possibly we can just remove the not required plugins from Hop and zip it up. So this step here might not be required any more.

Package is made up of:

- PDI or Hop libs
- The jar for the (handler) function that AWS Lambda calls.
- Optionally pipeline/transformation and workflows/jobs files

How to:

Define dependencies (pdi libs, default libs from aws, any libs that the steps require) in pom.xml

Use Maven Shade plugin to create the fat jar.

You can include the pipeline/transformation and workflows/jobs in the zip as well, but it's best practice to provide them externally (e.g. S3).


Build:

```
mvn package
```

> **Note**: Version of PDI in pom.xml

Then:

```
cd target; zip -d <file>.jar META-INF/*.RSA META-INF/*.DSA META-INF/*.SF
```

Test:

```
java -cp file.jar example.Test
```


## Step 2: Lambda Function

Define as envirnment variable `KETTLE_HOME` and set it to `/tmp` (that's the only writable directory), otherwise PDI won't start.

handler: this is the function **AWS Lambda** calls in your java code.

Make sure you make this function available as part of your package.

RequestHandler: points to `Test.java`
Dan had to use a hack - see `try` section - to write out the files but this shouldn't be required any more. 

At the end he added a `main` function so that he could test this locally (commented bit at the end)

## Further ideas

Next steps:

- Pass request object to PDI and extract values (e.g. S3 file upload)
- Hook it up with **API Gateway**: Pass through parameters that are on the URL.
