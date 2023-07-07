import React from 'react';
import ComponentCreator from '@docusaurus/ComponentCreator';

export default [
  {
    path: '/',
    component: ComponentCreator('/', 'c61'),
    routes: [
      {
        path: '/',
        component: ComponentCreator('/', '3bb'),
        exact: true,
        sidebar: "docs"
      },
      {
        path: '/contributing',
        component: ComponentCreator('/contributing', '956'),
        exact: true,
        sidebar: "docs"
      },
      {
        path: '/deployments',
        component: ComponentCreator('/deployments', 'aa8'),
        exact: true,
        sidebar: "docs"
      },
      {
        path: '/getting_started',
        component: ComponentCreator('/getting_started', 'cd9'),
        exact: true,
        sidebar: "docs"
      }
    ]
  },
  {
    path: '*',
    component: ComponentCreator('*'),
  },
];
