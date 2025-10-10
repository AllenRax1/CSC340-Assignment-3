package assignment3.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReptileRestController {

  @Autowired
  private ReptileService reptileService;

  /**
   * Endpoint to get all reptiles
   * 
   * @return List of all the reptiles
   */
  @GetMapping("/reptiles")
  public Object getAllReptiles() {
    return reptileService.getAllReptiles();
  }
  
  /**
   * Endpoint to get a reptile by ID
   * 
   * @param id the ID of the reptile to retrieve
   * @return the reptile with the specified ID
   */
   @GetMapping("/reptiles/{id}")
   public Reptile getReptileById(@PathVariable long id) {
    return reptileService.getReptileById(id);
   }

   /**
   * Endpoint to get reptiles by name
   *
   * @param name The name of the reptile to search for
   * @return List of reptiles with the specified name
   */
  @GetMapping("/reptiles/name")
  public Object getReptilesByName(@RequestParam String key) {
    if (key != null) {
      return reptileService.getReptilesByName(key);
    } else {
      return reptileService.getAllReptiles();
    }

  }


  /**Endpoint to get reptiles by species
   * 
   * @param major The major to search for
   * @return List of reptiles with the specified species
   */
  @GetMapping("/reptiles/species/{species}")
  public Object getReptilesBySpecies(@PathVariable String species) {
    return reptileService.getReptilesBySpecies(species);
  }

  /**
   * Endpoint to add a new reptile
   *
   * @param reptile The reptile to add
   * @return List of all reptiles
   */
  @PostMapping("/reptiles")
  public Object addReptile(@RequestBody Reptile reptile) {
    return reptileService.addReptile(reptile);
  }

  /**
   * Endpoint to update a reptile
   *
   * @param id      The ID of the reptile to update
   * @param reptile The updated reptile information
   * @return The updated reptile
   */
  @PutMapping("/reptiles/{id}")
  public Reptile updateReptile(@PathVariable Long id, @RequestBody Reptile reptile) {
    reptileService.updateReptile(id, reptile);
    return reptileService.getReptileById(id);
  }

  /**
   * Endpoint to delete a reptile
   *
   * @param id The ID of the reptile to delete
   * @return List of all reptiles
   */
  @DeleteMapping("/reptiles/{id}")
  public Object deleteReptile(@PathVariable Long id) {
    reptileService.deleteReptile(id);
    return reptileService.getAllReptiles();
  }

  /**
   * Endpoint to write a reptile to a JSON file
   *
   * @param reptile The reptile to write
   * @return An empty string indicating success
   */
  @PostMapping("/reptiles/writeFile")
  public Object writeJson(@RequestBody Reptile reptile) {
    return reptileService.writeJson(reptile);
  }

  /**
   * Endpoint to read a JSON file and return its contents
   *
   * @return The contents of the JSON file
   */
  @GetMapping("/reptiles/readFile")
  public Object readJson() {
    return reptileService.readJson();

  }

}
