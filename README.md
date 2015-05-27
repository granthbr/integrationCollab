#Integration Container Collaboration Repo

#####Collaborative effort to build simple integration processes for delivering data into an sync queue. 
The goal of this collaboration is to provide a set of simple integration components that are externally configurable, generic for ease of reusability, compact for ease of use and lack of overly complex routines for transparency. It is absolutely critical that each component is explained thouroghly in a README.md file so that third parties can reuse the component. The point of making this open is that each user of the repo can easily use any component.

This project is not specific to any particular framework or ESB. Any non-proprietary tool can be used (Spring Integration, Mule ESB, Camel/Karaf/Felix). The tool has to be open-source so that licensing restrictions on components do not restrict usage. 
Also, of course, all of these components can be reconfigured to satisfy whatever requirment the third party requires. 

#####Run it anywhere with Docker
I use this Docker image to run it anywhere and the same way it would be executed in production:

Here is the run command:

Understanding Docker is beyond the scope of this README but if you would like more information try this links (the last one is espeically helpful for running Mule CE in Docker containers):
*Docker in General:https://www.docker.com/whatisdocker/
*On Mac OSX (my preference):http://learningdocker.com/
*Running Mule with Docker:http://www.ivankrizsan.se/2015/01/18/mule-esb-in-docker/

#####A few requirements must be met in order to post source to the collaborative repo:

* Generic entry and exit points
* Personalization via property file

#####Options or optional 

* JSON description for building in Mesos

###### Explaination of directory structure

* docker contains files, resources, and Dockerfiles
* containers holds different application run times. There are a mule and camel folders currently. Collaborators can add simple integrations micro-services that deliver messages asynchronously.

######Individual components

*File to Active MQ ./containers/mule/fileToJMS
-Built for Mule CE 3.5.x
-Externally configure the retrieval point (file pickup), move file location, any other property for the Mule file component and JMS queue name via the mule.properties file located in ./containers/mule/fileToJMS/src/main/app/mule-app.properties.

