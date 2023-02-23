package vesseltracker.service;

import org.springframework.stereotype.Service;
import vesseltracker.model.Position;
import vesseltracker.repository.PositionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionService {

    private PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Position createPosition(int x, int y, String timeStamp) {

        return positionRepository.save(new Position(x, y, timeStamp));

    }

    public List<Position> CreateListPosition(List<Position> positions) {
        List<Position> positionCreatedList =  positions.stream()
                .map(position -> {
                    return createPosition(position.getX(), position.getY(), position.getTimestamp());
                }).collect(Collectors.toList());
        return positionCreatedList;
    }
}
