import { Link } from "@tanstack/react-router";
import Logo from "./logo";
import { navigations } from "@/data/navigation.data";
import { Button } from "./ui/button";
import {
  Sheet,
  SheetContent,
  SheetHeader,
  SheetTitle,
  SheetTrigger,
} from "./ui/sheet";
import { Menu } from "lucide-react";
import NavigationItem from "./navigation-item";

const Navigation = () => {
  return (
    <>
      <div className='hidden md:flex items-center gap-2'>
        <Link to='/dashboard'>
          <Logo />
        </Link>
        {navigations.map((item, index) => (
          <NavigationItem item={item} key={index} />
        ))}
      </div>
      <div className='md:hidden'>
        <Sheet>
          <SheetTrigger asChild>
            <Button variant={"ghost"} size={"sm"}>
              <Menu className='size-5' /> Menu
            </Button>
          </SheetTrigger>
          <SheetContent side='left'>
            <SheetHeader>
              <SheetTitle>
                <Logo />
              </SheetTitle>
            </SheetHeader>

            <div className='flex flex-col gap-4'>
              {navigations.map((item, index) => (
                <NavigationItem item={item} key={index} />
              ))}
            </div>
          </SheetContent>
        </Sheet>
      </div>
    </>
  );
};

export default Navigation;
