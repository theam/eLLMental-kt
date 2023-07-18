/**
 * Creating a sidebar enables you to:
 - create an ordered group of docs
 - render a sidebar for each doc of that group
 - provide next/previous navigation

 The sidebars can be generated from the filesystem, or explicitly defined here.

 Create as many sidebars as you want.
 */

// @ts-check

/** @type {import('@docusaurus/plugin-content-docs').SidebarsConfig} */
const sidebars = {
  // By default, Docusaurus generates a sidebar from the docs folder structure
  docs: [
    'introduction',
    'getting_started',
    {
      type: 'category',
      label: 'Deployments',
      items: ['deployments/aws', 'deployments/azure', 'deployments/container', 'deployments/gcp'],
      collapsed: true,
    },
    {
      type: 'category',
      label: 'Contributing',
      link: {
        type: 'doc',
        id: 'contributing/index'
      },
      items: [
        'contributing/index',
        'contributing/code_of_conduct',
      ]
    },
    {
      type: 'category',
      label: 'API Docs',
      items: [
        {
          type: 'autogenerated',
          dirName: 'api_docs'
        }
      ],
      collapsed: true
    }

  ],

  // But you can create a sidebar manually
  /*
  tutorialSidebar: [
    'intro',
    'hello',
    {
      type: 'category',
      label: 'Tutorial',
      items: ['tutorial-basics/create-a-document'],
    },
  ],
   */
};

module.exports = sidebars;
