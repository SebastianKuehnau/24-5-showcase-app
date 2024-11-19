package com.example.application.views.flowlayout;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;

@Menu(order = 10, title = "test")
@Route(value = "test", layout = FlowMainLayout.class)
public class TestView extends VerticalLayout {

    public TestView() {
        add(new Span("twest"));
    }
}
