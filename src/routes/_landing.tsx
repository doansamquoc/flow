import { createFileRoute, Link } from "@tanstack/react-router";
import { ArrowRight, Icon } from "lucide-react";
import { waveCircle } from "@lucide/lab";
import { Button } from "@/components/ui/button";

export const Route = createFileRoute("/_landing")({
  component: RouteComponent,
});

function RouteComponent() {
  return (
    <div>
      <nav className='p-2 flex gap-3 items-center'>
        <Link to='/' className='mr-auto flex gap-2'>
          Flow <Icon iconNode={waveCircle} />
        </Link>

        <Link to='/' className='[&.active]:underline'>
          Overview
        </Link>
        <Link to='/about' className='[&.active]:underline'>
          About
        </Link>

        <Button className='ml-auto' asChild>
          <Link to='/login'>
            Tham gia <ArrowRight />
          </Link>
        </Button>
      </nav>
    </div>
  );
}
