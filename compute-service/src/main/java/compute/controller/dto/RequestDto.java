package compute.controller.dto;

import compute.domain.AlgorithmType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestDto {

    private final AlgorithmType algorithmType;

    private final int input;
}
