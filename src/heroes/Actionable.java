package heroes;

import Mistakes.AbstractHeroException;
import events.Action;

public interface Actionable {
    Action performAction(Actions action);
}
