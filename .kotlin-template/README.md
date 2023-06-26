# YOLO

![YOLO](https://media.giphy.com/media/iIccX0vZzWEEM/giphy.gif)

You Only Live Once, so you should avoid wasting your time dealing with complicated and repetitive tasks.

That's why `yolo` exists—it's a technology-agnostic script runner designed to automate and standardize your workflows. It doesn't matter what technology stack your project uses, `yolo` makes building, linting, deploying, and running your tools and services straightforward and efficient. Plus, all available operations are self-documented and automatically discoverable.

## Getting Started

It all starts with a `yolo.json` file in your project's root. This simple configuration file describes your component using an easy-to-understand JSON format:

```json
{
  "name": "InvoiceService",
  "description": "A service to manage and process invoices.",
  "commands": [
    {
      "name": "test",
      "description": "Run all tests for the InvoiceService",
      "script": "npm run test",
      "args": []
    },
    {
      "name": "deploy",
      "description": "Deploy the service to a specified environment",
      "script": "./deploy.sh",
      "args": [
        {
          "name": "env",
          "type": "String",
          "description": "The environment to deploy to",
          "required": true
        }
      ]
    }
  ]
}
```

In this example, we have an invoicing service with two commands:

- `test`: This command runs all tests for the InvoiceService. It doesn't require any arguments.
- `deploy`: This command deploys the service to a specified environment. It requires one argument: the environment to deploy to.

To use these commands, you would type `yolo <command name>`. For example, to deploy the service to a `production` environment, you'd type `yolo deploy --env production`.

## "I came for JSON, but stayed for Dhall!"

Though `yolo` supports simple JSON configuration out of the box, we also offer native support for [Dhall](https://dhall-lang.org), a typed configuration language. Dhall adds powerful features like type checking, safety guarantees, and the ability to import and reuse schemas or configuration chunks from other files. This can help you build more complex and flexible configurations while maintaining readability and robustness.

Let's revisit our earlier example, but this time using Dhall:

```dhall
let Yolo = https://raw.githubusercontent.com/theam/yolo/main/schemas/YoloFile/package.dhall

let TestCommand =
      { name = "test"
      , description = Some "Run all tests for the InvoiceService"
      , script = "npm run test"
      , args = Yolo.noArgs
      , env = Yolo.noEnv
      }

let DeployCommand =
      { name = "deploy"
      , description = Some "Deploy the service to a specified environment"
      , script = "./deploy.sh"
      , args =
        [ { name = "env"
          , type = Some Yolo.Types.Text
          , description = Some "The environment to deploy to"
          , required = True
          , default = None Text
          }
        ]
      , env = Yolo.noArgs
      }

let YoloFile =
      { name = "InvoiceService"
      , description = Some "A service to manage and process invoices."
      , commands = [ TestCommand, DeployCommand ]
      }

in  YoloFile : Yolo.Schema
```

By using variables like `TestCommand` and `DeployCommand`, we make the configuration more readable and easier to manage. This way, it becomes clear where each command is defined, and it's easier to modify or extend each one independently. You can even define them in separate Dhall files and import them, further enhancing modularity and reuse.

## Contributing

We wholeheartedly welcome your contributions to the `yolo` project! If you encounter any bugs or have a feature request, please don't hesitate to [open an issue](https://github.com/theam/yolo/issues). We appreciate any feedback and we're always looking for ways to make `yolo` better.

You can also contribute by opening a pull request with changes or new features. When submitting a PR, please do your best to document your changes and include tests. We'll review your PR as quickly as we can and appreciate your patience in this matter.

For any major changes, we recommend opening an issue for discussion first. This way, you can ensure your time is well spent and your efforts align with the project's direction and goals.

## License

`yolo` is licensed under the Apache License 2.0. This means you're free to use and modify the project, but any distributions you make must retain the original copyright notice, state changes, and include the license itself. For full details, see the [LICENSE](LICENSE) file in the repository.