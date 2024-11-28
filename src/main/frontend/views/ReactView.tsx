import type { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import { VerticalLayout } from '@vaadin/react-components';

export const config: ViewConfig = {
  title: 'React View with Flow Layout!',
  route: 'flow/react-view',
  menu: {
    'order': 6,
    'title': 'React View with Flow Layout!',
    'icon': 'line-awesome/svg/react.svg'
  },
  flowLayout: true
};

export default function ReactTestView() {
  return (
    <VerticalLayout className="bg-contrast-10 p-m">
      <div>Hello React View!</div>
    </VerticalLayout>
  );
}