package ru.itcube46.rest.controllers;

import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import ru.itcube46.rest.repositories.UsersRepository;

@Slf4j
@RestController
@RequestMapping(path = "api/login", produces = "application/json")
public class LoginController {
    UsersRepository usersRepository;

    public LoginController(UsersRepository repository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public String test(@RequestParam(value = "idToken") String idToken, @RequestParam(value = "accessToken") String accessToken) {
        // Construct the URL
        String url = "https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token=" + accessToken;

        // Construct the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(idToken);

        // Construct the request entity
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        // Send the request and process the response
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        String responseBody = response.getBody();
        HttpStatusCode statusCode = response.getStatusCode();
        log.info("Response status code: " + statusCode); 
        log.info("Response body: " + responseBody);

        // Complete user authentication if successful
        if (statusCode.equals(200)) {
            log.info("HTTP 200");

            var generatedToken = UUID.randomUUID().toString().replaceAll("-", "0");
            //usersRepository.saveToken(googleMail, generatedToken);
            return generatedToken;
        } else {
            //ЭТО ПРИМЕР ЗАПРОСА К БАЗЕ ДАННЫХ В ДЖАВА СКРИПТ ДРУГОГО ПРОЕКТА, НО ОЧЕНЬ ПОМОЖЕТ ВАМ! ОНО ДОБАВЛЯЕТ НОВОГО ЮЗЕРА,
            //ЕСЛИ ОН ЗАХОДИТ ВПЕРВЫЕ, А ЕСЛИ НЕ ВПЕРВЫЕ, ТО ОНО ПРОСТО ПЕРЕГЕНЕРИРУЕТ ТОКЕН:)
            //`INSERT INTO users (email, auth_tempCode, auth_token)
            //VALUES (?, ?, ?)
            //ON DUPLICATE KEY UPDATE 
            //auth_tempCode = ?, auth_token = ? `
            return "failure";
        }

        
    }
}