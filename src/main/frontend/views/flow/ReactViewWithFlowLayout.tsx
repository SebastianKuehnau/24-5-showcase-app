import type { ViewConfig } from '@vaadin/hilla-file-router/types.js';

export const config: ViewConfig = {
  title: 'React View with Flow Layout!',
  route: 'react-view-with-flow-layout',
  menu: {
    'order': 6,
    'icon': 'line-awesome/svg/react.svg'
  },
  flowLayout: true
};

export default function ReactViewWithFlowLayout() {
  return (
    <div>Hello React World</div>
  );
}