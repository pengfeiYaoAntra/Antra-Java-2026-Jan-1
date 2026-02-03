package com.example.firsttwoweek;

/**
 * 7 layers model(OSI model)
 * application layer (user interface)
 * Presentation layer: (translation)
 * session layer (communication)
 * transport layer (reliability) where your tcp and udp live
 * network layer (routing) ip address, routing, datagrams
 * data link layer: MAC address  (local delivery - > node to node within the same local network)
 * physical layer: bits into 0s and 1s and converting electrical signal
 *
 * TCP/IP model
 * 1 application layer: this combines osi application, presentation and session layers
 * 2: transport layer: TCP. gets data from one host to another host
 * 3: Internet layer: like network layer in osi model. ip address
 * 4: network access layer, data link layer and physical. layer, mac address.
 *
 * SYN: used to establish the connection between client and server
 * ACK: let us know the other side that it has received SYN
 * ACKnum: next sequences number that receiver expects to receive
 * FIN: to terminate the connection
 * SEQ: keep track how many data it has sent
 *
 *
 *
 * TCP
 *
 *          client                               server
 * SYN and seq                      ->>
 *                      <<--                ACK, SYN
 *           SYN seq, ACK -->>
 *
 *
 * UDP
 *
 * connectionless: there is no handshake. the sender just start pushing data to the destination
 * No ordering: data can arrive out of order.
 * yes it is faster. it does not have header(more data) or a handshake
 * unreliable: it does not track data. no ACK
 * steps:
 *      data is prepared
 *      data is sent
 *      data is received
 *      data is extracted
 *
 *  DNS:
 *      www.google.com -> hits enter -> ip address: 123.123.123.123
 *      is used to translate human readable domain names into ip address.
 *
 *   *****HTTP****!!!!!
 *
 *   allows you to fetch data like html, video, image, text...
 *
 *   stateless: each request from a client to a server is treated independently.
 *   headers: includes metadata: content type, content length, server information...
 *   status code: 100, 200, 300, 400, 500.
 *   Methods: get, post, delete...
 *
 *   *****HTTP methods****!!!
 *   get: retrieves data
 *   POST: sends data the server to create or update a resource.
 *   PUT: replace all current resources.
 *   delete: delete resources
 *   patch: partial modification to a resources
 *
 *   ****HTTPS status code****
 *   1XX: Informational: your request is received and you can continue process.
 *   2XX: success: indicates that the client's request was successfully received, understood and accepted
 *   3XX:redirection: request is redirected to somewhere else
 *   4XX:client error: 404
 *   5XX: server error
 *
 *   HTTPS
 *   Symmetric algo -> will use the same key for both encryption and decryption.
 *   Asymmetric algo -> two keys: public and private
 *                  public used for encryption and private key is kept secret and used for decryption
 *    HTTPS is used asymmetric algo
 *    HTTPS = HTTP + TLS
 *
 *    if you are creating restful apis, you are using http 1.1
 *
 *    gRPC: uses HTTP2
 *    when you call is made to internal system. high - throughput, many services -> gRPC
 *    when your calls are facing external, web/mobile clients. -> REST
 *
 *    gRPC: synchronous request/response protocal ..  -> do this now and tell me the result.
 *    Kafka: Asynchronous event streaming -> here is what happened in my service(some data is updated) whoever cares can process it
 *
 *
 *    design pattern
 *
 *    singleton pattern: it provides only one instance of a class. your JVM has only one object.
 *    in spring boot: every @Service or Component annotation.. you create is a singleton by default
 *    eager initialization: the singleton instance is created at the time of class loading.
 *    lazy initialization : the singleton instance is created when you need.
 *    class Lazy{
 *        private static Lazy instance;
 *        private Lazy(){}
 *        public static Lazy getInstance(){
 *            if(instance == null){
 *                instance = new Lazy();
 *            }
 *            return instance
 *        }
 *    }
 *    class Eager{
 *        private static final Eager instance = new Eager();
 *        private Eager(){}
 *        public static Eager getInstance(){
 *            return instance;
 *        }
 *    }
 *
 *
 *    Prototype pattern
 *    copy an existing object rather than creating a new instance from scratch.
 *    class Sheep implements Cloneable{
 *
 *
 *        ..//
 *
 * @Override
 * protected Object clone() throws Exception{
 *     return super.clone();
 * }
 *    }
 *    cloning can be more efficient than creating new one
 *
 *
 *    Factory
 *     Cars: BMW, Toyota ...
 *     LoggerFactory.getLogger(BMW.class) -> will create BMW logger
 *     LoggerFactory.getLogger(Toyota.class) -> create Toyota logger
 *
 *    Builder
 *    @Builder from lombok
 * public class Course {}
 * do the construction of a complex object
 * Course course = Course.builder()
 *         .id(UUID.randomUUID())
 *         .code(courseRequest.getCode())
 *         .title(courseRequest.getTitle())
 *         .creditHours(courseRequest.getCreditHours())
 *         .instructorId(courseRequest.getInstructorId())
 *         .description(courseRequest.getDescription())
 *         .build();
 *
 *
 *
 *        Proxy: provides a placeholder for another object to control access to it.
 *                  Spring AOP uses proxies. when you use transactional annotation(@Transactional), spring
 *                  creates a proxy around your method to handle starting and commiting the database transaction.
 *
 *
 *        Observer
 *        publish - subscribe mechanism where one object notifies many objects about state changes. (Kafka)
 *        when one object (the subject) changes states, all its dependents (Observers) are notified and updated.
 *
 *
 *
 *
 *
 *
 */

public class Day6 {
}
