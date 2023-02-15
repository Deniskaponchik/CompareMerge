package org.example;
import com.beust.jcommander.Parameter;

public class Jcommander {

    Args args = new Args();
    String[] argv = { "-log", "2", "-groups", "unit" };
    JCommander.newBuilder()
        .addObject(args)
        .build()
        .parse(argv);

    Assert.assertEquals(jct.verbose.intValue(), 2);

}


public class Args {
    @Parameter
    private List<String> parameters = new ArrayList<>();

    @Parameter(names = { "-log", "-verbose" }, description = "Level of verbosity")
    private Integer verbose = 1;

    @Parameter(names = "-groups", description = "Comma-separated list of group names to be run")
    private String groups;

    @Parameter(names = "-debug", description = "Debug mode")
    private boolean debug = false;
}