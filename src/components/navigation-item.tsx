import { Button } from "./ui/button";
import { Link } from "@tanstack/react-router";
import type { Navigation } from "@/features/auth/types/navigation";

interface NavigationItemProps {
  item: Navigation;
}

const NavigationItem = ({ item }: NavigationItemProps) => {
  return (
    <Button size={"default"} variant={"ghost"} asChild>
      <Link to={item.path}>
        {item.icon} {item.label}
      </Link>
    </Button>
  );
};

export default NavigationItem;
