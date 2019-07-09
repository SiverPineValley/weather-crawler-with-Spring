package org.ajou.realcoding.weathercrawler.weathercrawler.controller;

import org.ajou.realcoding.weathercrawler.weathercrawler.domain.Dog;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DogController {
    List<Dog> dogs = new ArrayList<>();

    @PostMapping("/dogs") // http://localhost:8081/dogs
    public Dog createDog(@RequestBody Dog dog){
        dogs.add(dog);
        return dog;
    }

    @GetMapping("/dog/{name}") // /dogs/ian
    public Dog findDog(@PathVariable String name){
        for (Dog dog : dogs) {
            if (dog.getName().equals(name)) {
                return dog;
            }
        }
        return null;
    }

    @GetMapping("/dogs") // /dogs/ian
    public List<Dog> findDog(){
        return dogs;
    }

    @PutMapping("/dogs")
    public Dog updateDog(@RequestParam String name, @RequestBody Dog dog)
    {
        for(int i = 0; i < dogs.size(); i++)
        {
            if(dogs.get(i).getName().equals(name))
            {
                dogs.get(i).setName(dog.getName());
                dogs.get(i).setKind(dog.getKind());
                return dogs.get(i);
            }
        }
        return null;
    }

    @DeleteMapping("/dogs")
    public String deleteDog(@RequestParam String name, @RequestParam String kind)
    {
        for(int i = 0; i < dogs.size(); i++)
        {
            if(dogs.get(i).getName().equals(name) && dogs.get(i).getKind().equals(kind))
            {
                dogs.remove(dogs.get(i));
                return "Success!";
            }
        }
        return "No Dog...";
    }

}