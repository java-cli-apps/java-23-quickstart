//usr/bin/env java --enable-preview --class-path ${APP_DIR:-.}/lib/'*' "$0" "$@"; exit $?

import language.api.Greeter;
import language.api.Greeter.Language;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

void main(String... args) {
    var method = CommandLine.getCommandMethods(getClass(), null).getFirst();
    var commandLine = new CommandLine(method);
    int exitCode = commandLine.execute(args);
    System.exit(exitCode);
}

@Command(name = "PolyglotHello", mixinStandardHelpOptions = true)
private int polyglotHello(
        @Option(names = {"-l", "--language"}, required = true, description = "Valid values are: ${COMPLETION-CANDIDATES}")
        Language language
) {
    println(Greeter.byLanguage(language).greet());
    return CommandLine.ExitCode.OK;
}
