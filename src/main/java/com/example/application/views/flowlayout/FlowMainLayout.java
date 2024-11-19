package com.example.application.views.flowlayout;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@ParentLayout(MainLayout.class)
@Layout("flow")
@AnonymousAllowed
public class FlowMainLayout extends VerticalLayout implements RouterLayout {

    final Div content = new Div();

    public FlowMainLayout() {
        add(new Span("Flow Layout"), content);
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        this.content.getElement().appendChild(content.getElement());
    }
}
