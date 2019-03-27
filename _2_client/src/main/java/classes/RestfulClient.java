package classes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestfulClient {
    RestTemplate restTemplate;

    public RestfulClient() {
        restTemplate = new RestTemplate();
    }

    /**
     * get Entity
     */
    public User getEntity() {
        System.out.println("Beginning /GET request!");
        String getUrl = "http://localhost:8080/get?username=Florentin&hash=abcdef";
        User getResponse = restTemplate.getForObject(getUrl, User.class); // User user = restTemplate.getForObject(getUrl, User.class); WHICH ONE IS BETTER? // DIFFERENT RESPONSES
        System.out.println(getResponse.toString());
        return getResponse;
    }

    /**
     * get all activities
     */
    public List<Activity> getAllActivities(User user) {
        String url = "http://localhost:8080/firstactivities";
        List<Activity> res = restTemplate.postForObject(url, user, List.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Activity> activities = mapper.convertValue(res, new TypeReference<List<Activity>>() {
        });
        return activities;
    }


    /**
     * @param vehicle
     * @return
     */
    public List<Transport> addTransport(Transport vehicle) {
        String url = "http://localhost:8080/transport/add";
        List<Transport> res = restTemplate.postForObject(url, vehicle, List.class);
        System.out.println(res.toString());
        System.out.println(res.size());
        ObjectMapper mapper = new ObjectMapper();
        List<Transport> vehicles = mapper.convertValue(res, new TypeReference<List<Transport>>() {
        });
        System.out.println(vehicles.size());
        return vehicles;
    }

    /**
     * @param activity
     * @return
     */
    public List<Activity> addActivity(Activity activity) {
        String url = "http://localhost:8080/test";
        List<Activity> res = (List<Activity>) restTemplate.postForObject(url, activity, List.class);
        System.out.println("Response: " + res.toString());
        ObjectMapper mapper = new ObjectMapper();
        List<Activity> activities = mapper.convertValue(res, new TypeReference<List<Activity>>() {
        });
        return activities;
    }

    /**
     * this method sends a registration request and receives a message - POSITIVE OR NEGATIVE -
     *
     * @param user
     * @return
     */
    public String postEntity(User user) {
        System.out.println("Beginning /POST request");
        String postUrl = "http://localhost:8080/post";
        ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, user, String.class);
        System.out.println("Response for Post Request: " + postResponse.getBody());
        return postResponse.getBody();
    }

    /**
     * this method sends a registration request and receives a message - POSITIVE OR NEGATIVE -
     *
     * @param user
     * @return
     */
    public String login(User user) {
        System.out.println("Beginning /login request");
        String postUrl = "http://localhost:8080/login";
        ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, user, String.class);
        System.out.println("Response for Post Request: " + postResponse.getBody());
        return postResponse.getBody();
    }

    /**
     * @param user
     * @return
     */
    public String activity(User user) {
        System.out.println("beginning /activity request");
        String postUrl = "http://localhost:8080/activity";
        ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, user, String.class);
        System.out.println("Response for get request");
        return postResponse.getBody();
    }

    /**
     * @param user
     * @return
     */
    public User getUpdates(User user) {
        System.out.println("Beginning /requestforupdate request");
        String postUrl = "http://localhost:8080/requestforupdate";
        ResponseEntity<User> getUpdate = restTemplate.postForEntity(postUrl, user, User.class);
        System.out.println("Response for Post Request: " + getUpdate.getBody());
        return getUpdate.getBody();
    }

    /**
     * method for getting all the friends.
     */
    public List<User> getAllFriends(User user){
        String url = "http://localhost:8080/friendship/friends";
        List<User> res = restTemplate.postForObject(url, user, List.class);
        ObjectMapper mapper = new ObjectMapper();
        List<User> result = mapper.convertValue(res, new TypeReference<List<User>>(){});
        return result;
    }

    /**
     * method for getting all the friend requests.
     */
    public List<FriendRequest> getAllFriendRequests(User user){
        String url = "http://localhost:8080/friendship/getallrequests";
        List<FriendRequest> res = restTemplate.postForObject(url, user, List.class);
        System.out.println(res);
        ObjectMapper mapper = new ObjectMapper();
        List<FriendRequest> result = mapper.convertValue(res, new TypeReference<List<FriendRequest>>(){});
        return result;
    }

    /**
     * method for making a request.
     */
    public String sendFriendRequest(FriendRequest friendRequest){
        System.out.println("beginning /activity request");
        String postUrl = "http://localhost:8080/friendship/request";
        ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, friendRequest, String.class);
        System.out.println("Response for get request");
        return postResponse.getBody();
    }

    /**
     * method for replying to a friend request.
     */
    public String respond(FriendRequest friendRequest){
        System.out.println("beginning /activity request");
        String postUrl = "http://localhost:8080/friendship/respond";
        ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, friendRequest, String.class);
        System.out.println("Response for get request");
        return postResponse.getBody();
    }
    /**
     * @param restTemplate
     */
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //    public List<Transport> getAllVehicles(User user){
//        String url = "http://localhost:8080/transport/add";
//        List<Transport> res = restTemplate.postForObject(url, user, List.class);
//        ObjectMapper mapper = new ObjectMapper();
//        List<Transport> vehicles = mapper.convertValue(res, new TypeReference<List<Transport>>() { });
//        return vehicles;
//    }
}