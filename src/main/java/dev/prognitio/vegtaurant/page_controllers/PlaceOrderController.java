package dev.prognitio.vegtaurant.page_controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.prognitio.vegtaurant.data_storage.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.naming.AuthenticationException;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
public class PlaceOrderController {

    private final RestaurantLocationRepository locationRepository;
    private final AuthTokensRepository authTokensRepository;
    private final PlacedOrderRepository placedOrderRepository;
    private final RestaurantRatingRepository restaurantRatingRespository;

    public PlaceOrderController(RestaurantLocationRepository locationRepository, AuthTokensRepository authTokensRepository, PlacedOrderRepository placedOrderRepository, RestaurantRatingRepository restaurantRatingRespository) {
        this.locationRepository = locationRepository;
        this.authTokensRepository = authTokensRepository;
        this.placedOrderRepository = placedOrderRepository;
        this.restaurantRatingRespository = restaurantRatingRespository;
    }


    @GetMapping("/order")
    public String placeOrder(Model model, HttpServletRequest request, @CookieValue(value = "sessiontoken", defaultValue = "null") String sessionToken) {

        Account acc;

        try {
            acc = AccountController.retrieveAccountFromToken(sessionToken, request.getRemoteAddr(), authTokensRepository);
            model.addAttribute("headerpicturelink", acc.getImageUrl());
            model.addAttribute("account", "set");
            model.addAttribute("name", acc.getName());
            model.addAttribute("address", acc.getAddress());
            model.addAttribute("city", acc.getCity());
            model.addAttribute("state", acc.getState());
            model.addAttribute("country", acc.getCountry());
            model.addAttribute("zip", acc.getZip());
            model.addAttribute("phone", acc.getPhone());
            model.addAttribute("cardnum", acc.getCardNumber());
            model.addAttribute("expirdate", acc.getExpirationDate());
            model.addAttribute("securitycode", acc.getSecurityCode());
        } catch (AuthenticationException e) {
            model.addAttribute("headerpicturelink", "/images/default-avatar-icon.jpg");
            model.addAttribute("account", "noaccount");
            model.addAttribute("name", "");
            model.addAttribute("address", "");
            model.addAttribute("city", "");
            model.addAttribute("state", "");
            model.addAttribute("country", "");
            model.addAttribute("zip", "");
            model.addAttribute("phone", "");
            model.addAttribute("cardnum", "");
            model.addAttribute("expirdate", "");
            model.addAttribute("securitycode", "");
        }

        model.addAttribute("locations", locationRepository.findAll());

        return "order";
    }



    @PostMapping("/order")
    public ResponseEntity<String> placeOrderToAccount(Model model, @RequestBody String data, HttpServletRequest request, @CookieValue(value = "sessiontoken", defaultValue = "null") String sessionToken) {

        Account acc;

        try {
            acc = AccountController.retrieveAccountFromToken(sessionToken, request.getRemoteAddr(), authTokensRepository);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("failed", HttpStatus.OK);
        }
        model.addAttribute("headerpicturelink", acc.getImageUrl());


        PlacedOrder order = new PlacedOrder();
        order.setAccount(acc);
        order.setCartString(data.substring(data.indexOf("_")));
        order.setOrderDate(LocalDateTime.now());
        order.setEstimatedDeliveryTime(Integer.parseInt(data.substring(0, data.indexOf("_"))));
        placedOrderRepository.save(order);

        System.out.println(data);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }


    @PostMapping("/order/restaurantrating")
    public ResponseEntity<String> rateRestaurant(Model model, @RequestBody String data, HttpServletRequest request, @CookieValue(value = "sessiontoken", defaultValue = "null") String sessionToken) {

        Account acc;

        try {
            acc = AccountController.retrieveAccountFromToken(sessionToken, request.getRemoteAddr(), authTokensRepository);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("failed", HttpStatus.OK);
        }
        model.addAttribute("headerpicturelink", acc.getImageUrl());

        int ratingValue;
        String ratingStr;

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(data);
            ratingValue = node.get("ratingvalue").asInt();
            ratingStr = node.get("ratingcontent").asText();
        } catch (IOException e) {
            return new ResponseEntity<>("failed", HttpStatus.OK);
        }

        RestaurantRating rating = new RestaurantRating();
        if (ratingValue > 5) {
            rating.setRating(5);
        } else if (ratingValue < 1) {
            rating.setRating(1);
        } else {
            rating.setRating(ratingValue);
        }

        rating.setMessage(ratingStr);
        rating.setReviewer(acc);;
        restaurantRatingRespository.save(rating);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
