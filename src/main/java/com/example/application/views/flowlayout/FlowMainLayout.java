package com.example.application.views.flowlayout;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RouterLayout;

@Layout("/flow")
@PageTitle("Flow Layouts for Hilla/React")
@ParentLayout(MainLayout.class)
public class FlowMainLayout extends VerticalLayout implements RouterLayout {

    private Div content = new Div();

    public FlowMainLayout() {
        add(new H3("Flow Main Layout"));
        addClassNames("bg-contrast-10", "p-m");
        content.setSizeFull();
        add(content);
    }

    @Override
    public void showRouterLayoutContent(HasElement newContent) {
        this.content.add((Component) newContent);
    }
}
