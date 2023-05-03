package tz.go.moh.him.esrs.mediator.ctc3;

import akka.actor.Actor;
import akka.actor.Props;
import akka.actor.UntypedActor;

import java.util.List;

/**
 * Utility for launching actors
 */
public class TestMockLauncher extends UntypedActor {
    public TestMockLauncher(List<ActorToLaunch> actorsToLaunch) {
        for (ActorToLaunch actorToLaunch : actorsToLaunch) {
            if (actorToLaunch.args != null)
                getContext().actorOf(Props.create(actorToLaunch.actorClass, actorToLaunch.args), actorToLaunch.name);
            else
                getContext().actorOf(Props.create(actorToLaunch.actorClass), actorToLaunch.name);
        }
    }

    @Override
    public void onReceive(Object msg) throws Exception {
        unhandled(msg);
    }

    public static class ActorToLaunch {
        private String name;
        private Class<? extends Actor> actorClass;
        private Object args;

        public ActorToLaunch(String name, Class<? extends Actor> actorClass, Object args) {
            this.name = name;
            this.actorClass = actorClass;
            this.args = args;
        }
    }
}