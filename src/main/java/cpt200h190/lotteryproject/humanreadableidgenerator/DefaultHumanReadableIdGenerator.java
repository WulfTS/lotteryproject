package cpt200h190.lotteryproject.humanreadableidgenerator;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultHumanReadableIdGenerator implements HumanReadableIdGenerator {

}
