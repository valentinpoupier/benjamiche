package be.technifutur.benjamiche.service.impl;

import be.technifutur.benjamiche.exceptions.ResourceNotFoundException;
import be.technifutur.benjamiche.form.SandwichForm;
import be.technifutur.benjamiche.model.dto.SandwichDTO;
import be.technifutur.benjamiche.model.entity.Diet;
import be.technifutur.benjamiche.model.entity.Ingredient;
import be.technifutur.benjamiche.model.entity.Sandwich;
import be.technifutur.benjamiche.model.entity.User;
import be.technifutur.benjamiche.repository.*;
import be.technifutur.benjamiche.service.SandwichService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SandwichServiceImpl implements SandwichService {

    private final SandwichRepository sandwichRepository;
    private final DietRepository dietRepository;

    private final IngredientRepository ingredientRepository;


    public SandwichServiceImpl(SandwichRepository sandwichRepository, DietRepository dietRepository, IngredientRepository ingredientRepository) {
        this.sandwichRepository = sandwichRepository;
        this.dietRepository = dietRepository;
        this.ingredientRepository = ingredientRepository;

    }

    @Override
    public void createSandwich(SandwichForm form) {

        Sandwich sandwich = form.toEntity();

        Diet diet = dietRepository.findById(form.getDietId())
                .orElseThrow(ResourceNotFoundException::new);
        Set<Ingredient> ingredients = Set.copyOf(ingredientRepository.findAllById(form.getIngredients()));

        sandwich.setDiet(diet);
        sandwich.setIngredients(ingredients);

        sandwichRepository.save(sandwich);
    }

    @Override
    public SandwichDTO getOne(long sandwichId) {
        return sandwichRepository.findById(sandwichId)
                .map(SandwichDTO::from)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<SandwichDTO> getAll() {
        return sandwichRepository.findAll().stream()
                .map(SandwichDTO::from)
                .toList();
    }

    @Override
    public void updateSandwich(SandwichForm form, long sandwichId) {
        Sandwich sandwich = sandwichRepository.findById(sandwichId)
                .orElseThrow(ResourceNotFoundException::new);
        sandwich.setDiet(form.toEntity().getDiet());
        sandwich.setIngredients(form.toEntity().getIngredients());
        sandwich.setName(form.getName());
        sandwich.setDescription(form.getDescription());
        sandwich.setPrice(form.getPrice());
        sandwichRepository.save(sandwich);
    }

    @Override
    public void deleteSandwich(long sandwichId) {
        sandwichRepository.deleteById(sandwichId);
    }

}
