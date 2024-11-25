package com.example.application.views.flowlayout;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@Menu(order = 10, title = "Flow View with Flow Layout!", icon = LineAwesomeIconUrl.VAADIN)
@Route(value = "flow/test-view")
public class FlowTestView extends Div {

    public FlowTestView() {
        add(new Span("Hello Flow World!"));
    }
}
