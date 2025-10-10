package assignment3.assignment3;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ReptileService {

    @Autowired
    private ReptileRepository reptileRepository;

    /**
     * Method to get all Reptiles
     * 
     * @return List of all Reptiles
     */
    public Object getAllReptiles() {
        return reptileRepository.findAll();
    }

    /**
     * Method to get a Reptile by its ID.
     * 
     * @param reptileId the ID of the Reptile to retrieve.
     * @return The Reptile with the specified ID, or null if not found.
     */

    public Reptile getReptileById(@PathVariable long reptileId) {
    return reptileRepository.findById(reptileId).orElse(null);
  }

  /**
   * Method to get reptiles by name
   * 
   * @param name The name of the reptile to search for
   * @return List of reptiles with the specified name
   */
  public Object getReptilesByName(String name) {
    return reptileRepository.getReptilesByName(name);
  }

  /**Method to get reptiles by species
   * 
   * @param species The species to search for.
   * @return List of reptiles with the specified species
   */
  public Object getReptilesBySpecies(String species) {
    return reptileRepository.getReptilesBySpecies(species);
  }

  /**Method to get reptiles by age
   * 
   * @param age The age threshold to search for.
   * @return List of reptiles with age greater than or equal to the specified age
   */
  public Object getReptilesByAge(Double age) {
    return reptileRepository.getReptilesByAge(age);
  }

  /**
   * Method to add a new reptile
   *
   * @param reptile The reptile to add
   */
  public Reptile addReptile(Reptile reptile) {
    return reptileRepository.save(reptile);
  }

  /**
   * Method to update a reptile
   * 
   * @param reptileId the ID of the reptile to update
   * @param reptile The updated reptile information
   */
  public Reptile updateReptile(Long reptileId, Reptile reptile) {
    return reptileRepository.save(reptile);
  }

  /**
   * Method to delete a reptile
   * 
   * @param reptileId the ID of the reptile to delete from the database
   */
  public void deleteReptile(Long reptileId) {
    reptileRepository.deleteById(reptileId);
  }

  /**
   * Method to write a reptile object to a JSON file
   * 
   * @param reptile The reptile object to write to the file
   */
  public String writeJson(Reptile reptile) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.writeValue(new File("reptile.json"), reptile);
      return "Reptile written to JSON File successfully!";
    } catch (IOException e) {
      e.printStackTrace();
      return "Error writing reptile to JSON file.";
    }
  }

  /**
   * Method to read the reptile object from a JSON file
   *
   * @return The reptile object read from the JSON file
   */
  public Object readJson() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File("reptile.json"), Reptile.class);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }

  }
}

