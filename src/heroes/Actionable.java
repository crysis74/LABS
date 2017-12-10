package heroes;

import events.Action;

public interface Actionable {
    Action performAction(Actions action);
}
