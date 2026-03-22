import { User2 } from "lucide-react";
import { Button } from "./ui/button";
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuGroup,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from "./ui/dropdown-menu";
import { useNavigate } from "@tanstack/react-router";
import { userMenus } from "@/data/user-menu.data";
import type { UserMenu } from "@/features/auth/types/user-menu.type";
import { magic } from "@/lib/magic";

const UserDropdownMenu = () => {
  const navigate = useNavigate();

  const actionMap: Record<string, () => void> = {
    logout: async () => {
      await magic.user.logout();
      if (!magic.user.isLoggedIn()) {
        navigate({ to: "/login" });
      }
    },
    wallet: async () => {
      await magic.wallet.showUI();
    },
    balance: async () => {
      await magic.wallet.showBalances();
    },
    address: async () => {
      await magic.wallet.connectWithUI();
    },
  };

  const handleClick = (menu: UserMenu) => {
    switch (menu.type) {
      case "navigate":
        navigate({ to: menu.payload });
        break;
      case "action":
        actionMap[menu.payload]?.();
    }
  };

  return (
    <DropdownMenu>
      <DropdownMenuTrigger asChild>
        <Button variant={"ghost"}>
          <User2 />
          Tài khoản
        </Button>
      </DropdownMenuTrigger>
      <DropdownMenuContent align='end'>
        {userMenus.map((group, index) => (
          <div key={index}>
            <DropdownMenuGroup>
              {group.label && (
                <DropdownMenuLabel>{group.label}</DropdownMenuLabel>
              )}

              {group.items.map((menu) => (
                <DropdownMenuItem
                  key={menu.label}
                  onClick={() => handleClick(menu)}
                  variant={menu.isDestructive ? "destructive" : "default"}
                >
                  {menu.icon}
                  {menu.label}
                </DropdownMenuItem>
              ))}
            </DropdownMenuGroup>

            {index < userMenus.length - 1 && <DropdownMenuSeparator />}
          </div>
        ))}
      </DropdownMenuContent>
    </DropdownMenu>
  );
};

export default UserDropdownMenu;
