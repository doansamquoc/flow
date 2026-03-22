import { Button } from "./ui/button";
import { Plus } from "lucide-react";
import UserDropdownMenu from "./user-dropdown-menu";
import Navigation from "./navigation";

const Header = () => {
  return (
    <div className=''>
      <nav className='p-2 flex gap-2 items-center'>
        <Navigation />
        <Button variant={"ghost"} className='ml-auto'>
          Tạo
          <Plus />
        </Button>
        <UserDropdownMenu />
      </nav>
    </div>
  );
};

export default Header;
