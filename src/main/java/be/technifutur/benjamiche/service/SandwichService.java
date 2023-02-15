package be.technifutur.benjamiche.service;

import be.technifutur.benjamiche.form.SandwichForm;
import be.technifutur.benjamiche.model.dto.SandwichDTO;
import be.technifutur.benjamiche.model.entity.User;

import java.util.List;

public interface SandwichService {

    void createSandwich(SandwichForm form);

    SandwichDTO getOne(long sandwichId);

    List<SandwichDTO> getAll();

    void updateSandwich(SandwichForm form, long sandwichId);

    void deleteSandwich(long sandwichId);

}
