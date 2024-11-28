package com.example.application.views.flowlayout;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@Menu(order = 10, title = "Flow View with Flow Layout!", icon = LineAwesomeIconUrl.VAADIN)
@PageTitle("Flow View with Flow Layout!")
@Route(value = "flow/flow-view")
public class FlowView extends Div {

    public FlowView() {
        add(new Span("Hello Flow World!"));
    }
}
