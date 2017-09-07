package roadrationing.functions;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import roadrationing.regulation.ApplicableRule;
import roadrationing.regulation.RulesProcessor;

public class NumberAtTimeFunction implements Function<LocalDateTime, Set<String>> {

	private RulesProcessor rulesProcessor;

	@Override
	public Set<String> apply(LocalDateTime t) {
		LocalDateTime when = t == null ? LocalDateTime.now() : t;

		Optional<ApplicableRule> rule = rulesProcessor.findEffectiveRules(when);
		if (rule.isPresent()) {

			return rule.get().getNumbersOffRoad().getNumbers();
		} else

			return Collections.emptySet();
	}

	public RulesProcessor getRulesProcessor() {
		return rulesProcessor;
	}

	public void setRulesProcessor(RulesProcessor rulesProcessor) {
		this.rulesProcessor = rulesProcessor;
	}
	
	

}