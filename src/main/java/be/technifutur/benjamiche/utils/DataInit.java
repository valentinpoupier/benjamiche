package be.technifutur.benjamiche.utils;

import be.technifutur.benjamiche.model.entity.*;
import be.technifutur.benjamiche.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class DataInit implements InitializingBean {

    private final SandwichRepository sandwichRepository;
    private final DietRepository dietRepository;

    private final IngredientRepository ingredientRepository;

    private final PanierRepository panierRepository;

    private final UserRepository userRepository;

    public DataInit(SandwichRepository sandwichRepository, DietRepository dietRepository, IngredientRepository ingredientRepository, PanierRepository panierRepository, UserRepository userRepository) {
        this.sandwichRepository = sandwichRepository;
        this.dietRepository = dietRepository;
        this.ingredientRepository = ingredientRepository;
        this.panierRepository = panierRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        //---------------------------------------------
        // Diet

        Diet diet1 = new Diet();
        diet1.setName("Vegan");
        diet1.setDescription("Description 1");
        diet1 = dietRepository.save(diet1);

        Diet diet2 = new Diet();
        diet2.setName("Vegetarian");
        diet2.setDescription("Description 2");
        diet2 = dietRepository.save(diet2);

        Diet diet3 = new Diet();
        diet3.setName("Gluten Free");
        diet3.setDescription("Description 3");
        diet3 = dietRepository.save(diet3);

        Diet diet4 = new Diet();
        diet4.setName("Lactose Free");
        diet4.setDescription("Description 4");
        diet4 = dietRepository.save(diet4);

        Diet diet5 = new Diet();
        diet5.setName("Keto");
        diet5.setDescription("Description 5");
        diet5 = dietRepository.save(diet5);

        Diet diet6 = new Diet();
        diet6.setName("Paleo");
        diet6.setDescription("Description 6");
        diet6 = dietRepository.save(diet6);

        Diet diet7 = new Diet();
        diet7.setName("Pescetarian");
        diet7.setDescription("Description 7");
        diet7 = dietRepository.save(diet7);

        Diet diet8 = new Diet();
        diet8.setName("Raw");
        diet8.setDescription("Description 8");
        diet8 = dietRepository.save(diet8);

        Diet diet9 = new Diet();
        diet9.setName("Whole30");
        diet9.setDescription("Description 9");
        diet9 = dietRepository.save(diet9);

        Diet diet10 = new Diet();
        diet10.setName("FODMAP");
        diet10.setDescription("Description 10");
        diet10 = dietRepository.save(diet10);

        Diet diet11 = new Diet();
        diet11.setName("Mediterranean");
        diet11.setDescription("Description 11");
        diet11 = dietRepository.save(diet11);

        Diet diet12 = new Diet();
        diet12.setName("Low Carb");
        diet12.setDescription("Description 12");
        diet12 = dietRepository.save(diet12);

        Diet diet13 = new Diet();
        diet13.setName("Low Fat");
        diet13.setDescription("Description 13");
        diet13 = dietRepository.save(diet13);

        Diet diet14 = new Diet();
        diet14.setName("Low Sodium");
        diet14.setDescription("Description 14");
        diet14 = dietRepository.save(diet14);

        Diet diet15 = new Diet();
        diet15.setName("Low Sugar");
        diet15.setDescription("Description 15");
        diet15 = dietRepository.save(diet15);

        //---------------------------------------------
        // Ingredient

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("fromage");
        ingredientRepository.save(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("jambon");
        ingredientRepository.save(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setName("beurre");
        ingredientRepository.save(ingredient3);

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setName("tomate");
        ingredientRepository.save(ingredient4);

        Ingredient ingredient5 = new Ingredient();
        ingredient5.setName("mayonnaise");
        ingredientRepository.save(ingredient5);

        Ingredient ingredient6 = new Ingredient();
        ingredient6.setName("poulet");
        ingredientRepository.save(ingredient6);

        Ingredient ingredient7 = new Ingredient();
        ingredient7.setName("curry");
        ingredientRepository.save(ingredient7);

        Ingredient ingredient8 = new Ingredient();
        ingredient8.setName("salade");
        ingredientRepository.save(ingredient8);

        Ingredient ingredient9 = new Ingredient();
        ingredient9.setName("oignon");
        ingredientRepository.save(ingredient9);

        //---------------------------------------------
        // Sandwich

        Sandwich sandwich1 = new Sandwich();
        HashSet<Ingredient> ingredients = new HashSet<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);
        sandwich1.setIngredients(ingredients);
        sandwich1.setName("Sandwich 1");
        sandwich1.setPrice(1.0);
        sandwich1.setDescription("Description 1");
        sandwich1.setDiet(diet1);
        sandwich1 = sandwichRepository.save(sandwich1);

        Sandwich sandwich2 = new Sandwich();
        HashSet<Ingredient> ingredients2 = new HashSet<>();
        ingredients2.add(ingredient4);
        ingredients2.add(ingredient5);
        ingredients2.add(ingredient6);
        sandwich2.setIngredients(ingredients2);
        sandwich2.setName("Sandwich 2");
        sandwich2.setPrice(2.0);
        sandwich2.setDescription("Description 2");
        sandwich2.setDiet(diet2);
        sandwich2 = sandwichRepository.save(sandwich2);

        Sandwich sandwich3 = new Sandwich();
        HashSet<Ingredient> ingredients3 = new HashSet<>();
        ingredients3.add(ingredient7);
        ingredients3.add(ingredient8);
        ingredients3.add(ingredient9);
        sandwich3.setIngredients(ingredients3);
        sandwich3.setName("Sandwich 3");
        sandwich3.setPrice(3.0);
        sandwich3.setDescription("Description 3");
        sandwich3.setDiet(diet3);
        sandwich3 = sandwichRepository.save(sandwich3);

        Sandwich sandwich4 = new Sandwich();
        HashSet<Ingredient> ingredients4 = new HashSet<>();
        ingredients4.add(ingredient1);
        ingredients4.add(ingredient2);
        ingredients4.add(ingredient3);
        sandwich4.setIngredients(ingredients4);
        sandwich4.setName("Sandwich 4");
        sandwich4.setPrice(4.0);
        sandwich4.setDescription("Description 4");
        sandwich4.setDiet(diet4);
        sandwich4 = sandwichRepository.save(sandwich4);

        Sandwich sandwich5 = new Sandwich();
        HashSet<Ingredient> ingredients5 = new HashSet<>();
        ingredients5.add(ingredient4);
        ingredients5.add(ingredient5);
        ingredients5.add(ingredient6);
        sandwich5.setIngredients(ingredients5);
        sandwich5.setName("Sandwich 5");
        sandwich5.setPrice(5.0);
        sandwich5.setDescription("Description 5");
        sandwich5.setDiet(diet5);
        sandwich5 = sandwichRepository.save(sandwich5);

        Sandwich sandwich6 = new Sandwich();
        HashSet<Ingredient> ingredients6 = new HashSet<>();
        ingredients6.add(ingredient7);
        ingredients6.add(ingredient8);
        ingredients6.add(ingredient9);
        sandwich6.setIngredients(ingredients6);
        sandwich6.setName("Sandwich 6");
        sandwich6.setPrice(6.0);
        sandwich6.setDescription("Description 6");
        sandwich6.setDiet(diet1);
        sandwich6 = sandwichRepository.save(sandwich6);

        Sandwich sandwich7 = new Sandwich();
        HashSet<Ingredient> ingredients7 = new HashSet<>();
        ingredients7.add(ingredient1);
        ingredients7.add(ingredient2);
        ingredients7.add(ingredient3);
        sandwich7.setIngredients(ingredients7);
        sandwich7.setName("Sandwich 7");
        sandwich7.setPrice(7.0);
        sandwich7.setDescription("Description 7");
        sandwich7.setDiet(diet2);
        sandwich7 = sandwichRepository.save(sandwich7);

        Sandwich sandwich8 = new Sandwich();
        HashSet<Ingredient> ingredients8 = new HashSet<>();
        ingredients8.add(ingredient4);
        ingredients8.add(ingredient5);
        ingredients8.add(ingredient6);
        sandwich8.setIngredients(ingredients8);
        sandwich8.setName("Sandwich 8");
        sandwich8.setPrice(8.0);
        sandwich8.setDescription("Description 8");
        sandwich8.setDiet(diet3);
        sandwich8 = sandwichRepository.save(sandwich8);

        //---------------------------------------------
//        // User
//
//        User user1 = new User();
//        user1.setFirstName("John");
//        user1.setLastName("Doe");
//        user1.setUsername("uuu@ppp.pp");
//        user1.setPassword("pppp");
//        user1.setRoles(new HashSet<>(Arrays.asList("ROLE_USER")));
//        userRepository.save(user1);
//
//        //---------------------------------------------
//        // panier
//
//        Panier panier1 = new Panier();
//        panier1.setSandwiches(new ArrayList<>(Arrays.asList(sandwich1, sandwich2, sandwich3)));
//        panier1.setTotal(panier1.getSandwiches().stream().map(Sandwich::getPrice).reduce(0.0, Double::sum));
//        panier1.setUser(user1);
//        user1.setPanier(panier1);
//        panierRepository.save(panier1);
//        userRepository.save(user1);
//
//        // add sandwich to panier
//        List<Sandwich> sandwiches = panier1.getSandwiches();
//        sandwiches.add(sandwich4);
//        panier1.setSandwiches(sandwiches);
//        panier1.setTotal(panier1.getSandwiches().stream().map(Sandwich::getPrice).reduce(0.0, Double::sum));
//        panierRepository.save(panier1);
    }
}
