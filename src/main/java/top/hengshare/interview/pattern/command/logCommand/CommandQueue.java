package top.hengshare.interview.pattern.command.logCommand;

import com.google.common.collect.Queues;
import com.google.common.io.Files;
import org.apache.commons.lang3.CharSet;
import top.hengshare.interview.utils.FileOpeUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Queue;

public class CommandQueue {

    private static Queue<Command> cmds = null;

    private final static String FILE_NAME = "d:/CmdQueue.txt";

    static {
        cmds = FileOpeUtil.readFile(FILE_NAME);
        if (cmds == null) {
            cmds = Queues.newArrayDeque();
        }
    }

    public synchronized static void addMenu(MenuCommand menu) {
        for (Command cmd : menu.getCmds()) {
            cmds.add(cmd);
        }
        //记录请求日志
        FileOpeUtil.writeFile(FILE_NAME, cmds);
    }

    public synchronized static Command getOneCommand() {
        Command cmd = null;

        if (cmds.size() > 0) {
            cmd = cmds.poll();
        }
        //记录请求日志
        FileOpeUtil.writeFile(FILE_NAME, cmds);

        return cmd;
    }


}
