package io.github.matheus_fsantos.view;

import io.github.matheus_fsantos.engine.CpuCore;
import io.github.matheus_fsantos.view.utils.UiUtils;
import io.github.yehorsyrin.tui.core.Component;
import io.github.yehorsyrin.tui.core.Node;
import io.github.yehorsyrin.tui.event.EventBus;
import io.github.yehorsyrin.tui.event.KeyType;
import io.github.yehorsyrin.tui.node.Text;
import io.github.yehorsyrin.tui.node.TextNode;
import io.github.yehorsyrin.tui.node.VBox;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainView extends Component {
    private static final int MAX_WIDTH = 80;
    private static final String APP_NAME = " Chronos CLI ";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final CpuCore cpuCore;

    private boolean alive;
    private String hour;
    private float currentCpuUsage;


    public MainView() {
        this.alive = true;
        this.hour = " [XX:XX:XX] ";
        this.currentCpuUsage = 0;

        this.cpuCore = new CpuCore();
    }

    @Override
    public void mount(Runnable onStateChange, EventBus eventBus) {
        super.mount(onStateChange, eventBus);
        onKey(KeyType.ESCAPE, () -> setState(() -> this.alive = false));

        new Thread(() -> {
            while (this.alive) {
                setState(this::updateCurrentTime);
                setState(() -> this.currentCpuUsage = this.cpuCore.getCpuUsage());
                try { Thread.sleep(1000); } catch (InterruptedException ignored) { }
            }
        }).start();
    }

    @Override
    public Node render() {
        int count = 0;

        count = MAX_WIDTH - UiUtils.bLeftTop(1).length() - UiUtils.hLine(2).length() - APP_NAME.length() - this.hour.length() - UiUtils.hLine(2).length() - UiUtils.bRightTop(1).length();
        TextNode one = Text.of(UiUtils.bLeftTop(1) + UiUtils.hLine(2) + APP_NAME + UiUtils.hLine(count) + this.hour + UiUtils.hLine(2) + UiUtils.bRightTop(1));

        List<String> optionsList = List.of(" [F1] Dashboard ", " [F2] Processes ", " [ESC] Quit ");
        String options = String.join("", optionsList);
        count = MAX_WIDTH - UiUtils.vLine(1).length() - options.length() - UiUtils.vLine(1).length();
        TextNode two = Text.of(UiUtils.vLine(1) + options + UiUtils.empty(count) + UiUtils.vLine(1));

        count = MAX_WIDTH - UiUtils.hLeftDividerLine(1).length() - UiUtils.hRightDividerLine(1).length();
        TextNode three = Text.of(UiUtils.hLeftDividerLine(1) + UiUtils.hLine(count) + UiUtils.hRightDividerLine(1));

        TextNode four = createRow("");
        TextNode five = createRow(" Processor: " + this.cpuCore.getCpuName());
        TextNode six = createRow(this.createProgressBar(this.currentCpuUsage));

        return VBox.of(
            one,
            two,
            three,
            four,
            five,
            six
        );
    }

    public void updateCurrentTime() {
        this.hour = String.format(" [%s] ", LocalDateTime.now().format(FORMATTER));
    }

    public TextNode createRow(String rowContent) {
        int count = MAX_WIDTH - rowContent.length() - UiUtils.vLine(1).length() - UiUtils.vLine(1).length();
        return Text.of(UiUtils.vLine(1) +  rowContent + UiUtils.empty(count) + UiUtils.vLine(1));
    }

    public String createProgressBar(float progressPercent) {
        int barsCount = Math.round((20 * progressPercent)/100);
        int difference = 20 - barsCount;
        String bars = "█".repeat(barsCount) + "░".repeat(difference);
        return " " + bars + String.format(" %.2f%% Total Usage", progressPercent);
    }
}
