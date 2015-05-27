FROM granthbr/java-oracle-7
MAINTAINER Brandon Grantham <brandon.grantham@gmail.com> 

RUN wget https://repository.mulesoft.org/nexus/content/repositories/releases/org/mule/distributions/mule-standalone/3.6.1/mule-standalone-3.6.1.tar.gz 
RUN chmod 777 mule-standalone-3.6.1.tar.gz
RUN cd /opt && tar xvzf ../mule-standalone-3.6.1.tar.gz
RUN echo "4a94356f7401ac8be30a992a414ca9b9 /mule-standalone-3.6.1.tar.gz" |md5sum -c
RUN rm ~/mule-standalone-3.6.1.tar.gz
RUN ln -s /opt/mule-standalone-3.5.0 /opt/mule 

CMD ["/opt/mule/bin/mule"]

