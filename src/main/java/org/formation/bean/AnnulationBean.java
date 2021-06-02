package org.formation.bean;

import java.util.List;
import java.util.stream.Collectors;

import org.formation.model.Formation;

public class AnnulationBean {

  public static List<Formation> selectAnnulation() {
    return Formation.getAll().stream()
    .filter((s) -> s.isAnnulee()).collect(Collectors.toList());
  }
}
