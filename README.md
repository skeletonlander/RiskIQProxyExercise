#problem statement

You have a proxy service (a simple spring boot application) that interacts with a bunch of files.

1) One day your manager comes over to your desk and asks you to implement a metrics feature that calculates the number 
of rows in each file that your service interacts with.
    - Gather metrics every five minutes
    - Only keep the latest gathered metrics

2) Create a REST endpoint that someone can call from a browser to get the last gathered metrics.

3) You now want to introduce a new repository in your service that keeps track of service owners. The format of the file
is:

    service1, user1
    service2, user2
    service3, user3
    service4, user4
    
- Using the existing model class ServiceOwner, create a new repository and update metrics collection to include metrics
for the new repository.
- Add appropriate unit tests wherever applicable.

