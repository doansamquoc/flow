import { createFileRoute, Link, useLocation } from "@tanstack/react-router";
import { ArrowRight, Icon } from "lucide-react";
import { waveCircle } from "@lucide/lab";
import { Button } from "@/components/ui/button";
import { motion } from "framer-motion";

export const Route = createFileRoute("/_landing")({
  component: RouteComponent,
});

function RouteComponent() {
  const { pathname } = useLocation();
  const navLinks = [
    { to: "/", label: "Tổng quan" },
    { to: "/about", label: "Về chúng tôi" },
  ];

  return (
    <div>
      <nav className='p-2 flex gap-3 items-center'>
        <Link to='/' className='mr-auto flex gap-2'>
          Flow <Icon iconNode={waveCircle} />
        </Link>

        {navLinks.map((link, index) => (
          <Link
            key={index}
            to={link.to}
            className='relative py-1 text-sm font-medium transition-colors hover:text-primary'
          >
            {link.label}
            {pathname === link.to && (
              <motion.div
                layoutId='underline'
                className='absolute bottom-0 left-0 right-0 h-1 bg-blue-600'
                transition={{ type: "spring", stiffness: 380, damping: 10 }}
              />
            )}
          </Link>
        ))}

        <Button className='ml-auto' asChild>
          <Link to='/login'>
            Tham gia <ArrowRight />
          </Link>
        </Button>
      </nav>
    </div>
  );
}
