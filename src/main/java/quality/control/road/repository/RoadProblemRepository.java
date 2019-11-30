package quality.control.road.repository;

import quality.control.road.model.RoadProblem;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface RoadProblemRepository extends PagingAndSortingRepository<RoadProblem, Long> {

    List<RoadProblem> findAllByCity_Name(String cityName);
}
