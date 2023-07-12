# Ellmental(2)

![haha LLM go brrrrr](https://explosion.ai/static/1863c4dfa57ad28dbbd68e432bde34e9/66a58/llm-maximalism_meme.jpg)

## Contributing

We use IntelliJ IDEA for development. You can import the project as a Gradle project.

Install the `Save Actions Tool` plugin by `Alexandre DuBreuil` to automatically format the code on save.

Make sure you've configured it like this in your IDE (although it should be already configured because we
checked in the settings file):

![Save Actions Tool settings](./.docassets/format-on-save.png)

### Adding a new package into the monorepo

1. Duplicate the `.kotlin-template` folder and rename it to your package name.
2. Add the package name to the `settings.gradle.kts` file, in the `includes` list.
3. ???
4. Profit!