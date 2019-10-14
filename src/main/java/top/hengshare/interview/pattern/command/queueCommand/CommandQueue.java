package top.hengshare.interview.pattern.command.queueCommand;

import com.google.common.collect.Queues;

import java.util.Queue;

public class CommandQueue {

    private static Queue<Command> cmds = Queues.newArrayDeque();

    public synchronized static void addMenu(MenuCommand menu){
        for (Command cmd : menu.getCmds()) {
            cmds.add(cmd);
        }
    }

    public synchronized static Command getOneCommand(){
        Command cmd = null;

        if (cmds.size() > 0) {
            cmd = cmds.poll();
        }

        return cmd;
    }
}
