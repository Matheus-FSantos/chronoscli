package io.github.matheus_fsantos.view;

import io.github.yehorsyrin.tui.core.Component;
import io.github.yehorsyrin.tui.core.Node;
import io.github.yehorsyrin.tui.event.EventBus;
import io.github.yehorsyrin.tui.event.KeyType;
import io.github.yehorsyrin.tui.node.Divider;
import io.github.yehorsyrin.tui.node.HBox;
import io.github.yehorsyrin.tui.node.Text;
import io.github.yehorsyrin.tui.node.VBox;
import io.github.yehorsyrin.tui.style.Color;

public class CounterApp extends Component {
    private int count;

    public CounterApp() {
        this.count = 0;
    }

    @Override
    public void mount(Runnable onStateChange, EventBus eventBus) {
        super.mount(onStateChange, eventBus);
        onKey(KeyType.ARROW_UP, () -> setState(() -> count++));
        onKey(KeyType.ARROW_DOWN, () -> setState(() -> count--));
    }

    @Override
    public Node render() {
        return VBox.of(
            Text.of("Counter Demo").bold().color(Color.CYAN),
            Divider.horizontal(),
            HBox.of(
                Text.of("Count: ").dim(),
                Text.of(String.valueOf(count)).bold().color(Color.GREEN)
            ).gap(10),
            Text.of(""),
            Text.of("Up/Down: +/-   ESC: quit").dim()
        );
    }
}
